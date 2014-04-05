package ee.mangupidu.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import ee.mangupidu.dao.EventDao;
import ee.mangupidu.model.Event;

@Service
public class EventDaoImpl extends BaseDao implements EventDao{
	
	private BeanPropertyRowMapper<Event> mapper;

	@Override
	public List<Event> getAllEvents() {
		String sql = "SELECT * FROM event";
		return namedParameterJdbcTemplate.query(sql, getMapper());
	}

	@Override
	public Event getEvent(Long eventId) {
		String sql = "SELECT * FROM event WHERE id = ?";
		return namedParameterJdbcTemplate.getJdbcOperations().queryForObject(sql, getMapper(), eventId);
	}

	@Override
	public void addEvent(Event event) {
		String sql = "INSERT INTO event (description) VALUES (:description)";
		namedParameterJdbcTemplate.update(sql, getParameterSource(event));
	}
	

	@Override
	public void updateEvent(Event event) {
		String sql = "UPDATE event SET description = :description";
		namedParameterJdbcTemplate.update(sql, getParameterSource(event));
	}

	@Override
	public void deleteEvent(Long eventId) {
		String sql = "DELETE * FROM event WHERE id = ?";
		namedParameterJdbcTemplate.getJdbcOperations().update(sql, eventId);
	}

	private SqlParameterSource getParameterSource(Event event) {
		return new BeanPropertySqlParameterSource(event);
	}
	
	
	private RowMapper<Event> getMapper() {
		if(mapper == null){
			mapper = new BeanPropertyRowMapper<Event>(Event.class);
		}
		return mapper;
	}
	
}
