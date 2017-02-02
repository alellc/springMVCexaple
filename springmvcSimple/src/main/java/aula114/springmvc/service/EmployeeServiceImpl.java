package aula114.springmvc.service;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aula114.springmvc.domain.Contact;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
    private RedisTemplate redisTemplate;


	@Override
	public List<String> listIdEmployee() {
        List<String> list = new  ArrayList<String>();
        Set<Object> set = redisTemplate.opsForHash().keys("Contact");
        for(Object o : set){
        	list.add(o.toString());
        }
        return list;
	}

	@Override
	public Contact show(String id) {
		String sql ="select * from contact where id = ?";
		//Contact contact = jdbcTemplate.queryForObject(sql, new Object[]{id});

		return null;
	}
}
