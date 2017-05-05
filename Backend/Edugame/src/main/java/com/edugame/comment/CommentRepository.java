package com.edugame.comment;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Date>{

}
