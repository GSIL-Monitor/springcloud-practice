package com.dianping.hui.controller;

import com.dianping.hui.entity.User;
import com.dianping.hui.service.AggregationService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;

/**
 * @author: lanxinyu@meituan.com  2018-12-04 2:26 PM
 * @Description:
 */
@RestController
@Slf4j
public class AggregationController {
    @Autowired
    AggregationService service;

    @GetMapping("/aggregate/{id}")
    public DeferredResult<HashMap<String, User>> aggregate(
            @PathVariable Long id
    ) {
        Observable<HashMap<String, User>> result = aggregateObservable(id);
        return toDeferredResult(result);
    }

    private Observable<HashMap<String, User>> aggregateObservable(Long id) {
        //合并两个或者多个Observables发射出的数据项，根据指定的函数变换他们
        return Observable.zip(
                this.service.getUserById(id),
                this.service.getMovieUserByUserId(id),
                (user, movieUser) -> {
                    HashMap<String, User> map = Maps.newHashMap();
                    map.put("user", user);
                    map.put("movieUser", movieUser);
                    return map;
                }
        );
    }

    private DeferredResult<HashMap<String,User>> toDeferredResult(Observable<HashMap<String,User>> details) {
        DeferredResult<HashMap<String,User>> result = new DeferredResult<>();
        details.subscribe(new Observer<HashMap<String, User>>() {
            @Override
            public void onCompleted() {
                log.info("完成.....");
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("发生错误.....", throwable);
            }

            @Override
            public void onNext(HashMap<String, User> movieDetails) {
                result.setResult(movieDetails);
            }
        });
        return result;
    }
}
