package com.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 不要忘记添加，不要忘记添加
public class UserClientServiceFallbackFactory implements FallbackFactory<UserService>{



	public UserService create(Throwable throwable){


		return new UserService() {

			public User get(int id){
				return new User().setId(id).setLastname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
						.setDbSource("no this database in MySQL");
			}

			public List<User> list()
			{
				return null;
			}

		};
	}
}
