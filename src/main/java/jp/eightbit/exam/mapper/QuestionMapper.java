package jp.eightbit.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.eightbit.exam.entity.Questions;



@Mapper
public interface QuestionMapper {
	List<Questions> findAll();
	
	Questions findOne(Long id);
}
