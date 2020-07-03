package com.dsmanioto.persistencejparedis.repository.mock;

import com.dsmanioto.persistencejparedis.model.Provider;
import com.dsmanioto.persistencejparedis.repository.ProviderRepository;
import org.junit.jupiter.api.Assertions;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
public class ProviderRepositoryMockTest {

    @Autowired
    private ProviderRepository repository;

    @MockBean
    private RedisTemplate redisTemplate;

    @MockBean
    private HashOperations hashOperations;

    //@Test
    public void findAllMock() {
        BDDMockito.given(redisTemplate.opsForHash().get("provider", "1")).willReturn(getProvider());

        List<Provider> providers = (List<Provider>) repository.findById("1");

        Assertions.assertNotNull(providers);
        Assertions.assertEquals(1, providers.size());
    }

    private Provider getProvider() {
        return Provider.builder()
                .name("Daniel")
                .build();
    }

}
