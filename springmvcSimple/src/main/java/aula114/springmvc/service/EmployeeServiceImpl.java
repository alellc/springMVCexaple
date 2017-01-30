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
    private RedisTemplate<String, String> redisTemplate;
    private List<String> listIdEmployee;

    public EmployeeServiceImpl() {
		listIdEmployee = new ArrayList<String>();
	}

    public void setJdbcTemplate(JdbcTemplate t) {
      jdbcTemplate=t;
    }

	@Override
	public List<String> listIdEmployee() {
        listIdEmployee =  redisTemplate.opsForHash().keys(KEY);

        return listIdEmployee;
	}

	@Override
	public Contact show(String id) {
		String sql ="select * from contact where id = ?";
		Contact contact = jdbcTemplate.queryForObject(sql, new Object[]{id});

		return contact;
	}
}
