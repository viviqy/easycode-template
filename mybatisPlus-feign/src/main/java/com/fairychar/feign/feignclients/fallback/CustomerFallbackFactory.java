package com.fairychar.feign.feignclients.fallback;

import com.fairychar.bag.proxy.FeignFallbackProxy;
import com.fairychar.feign.feignclients.CustomerFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * (Customer)表服务接口类
 *
 * @author chiyo
 * @since 2021-09-15 12:56:03
 */
@Component
public class CustomerFallbackFactory implements FallbackFactory<CustomerFeignClient>  {
    @Override
    public CustomerFeignClient create(Throwable throwable) {
        return FeignFallbackProxy.createDefault(CustomerFeignClient.class,throwable);
    }
}


