package com.edugame.user;

import javax.transaction.Transactional;

@Transactional
public interface StudentRepository extends UserBaseRepository<Student>{

}
