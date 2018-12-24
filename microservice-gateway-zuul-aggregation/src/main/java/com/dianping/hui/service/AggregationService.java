package com.dianping.hui.service;

import com.dianping.hui.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

/**
 * @author: lanxinyu@meituan.com  2018-12-04 2:10 PM
 * @Description:
 */
@Service
public class AggregationService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${getuserbyid.microservice.uri}")
    private String getUserByIdURI;

    @Value("${getmovieuserbyid.microservice.uri}")
    private String getMovieUserByIdURI;

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserById(Long id) {
        //创建一个被观察者
        return Observable.create(observer -> {
            User user = restTemplate.getForObject(getUserByIdURI, User.class, id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getMovieUserByUserId(Long id) {
        return Observable.create(observer -> {
            User user = restTemplate.getForObject(getMovieUserByIdURI, User.class, id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }

    public User fallback(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("error user");
        return user;
    }
}
