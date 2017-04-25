package com.edugame.user;

import javax.transaction.Transactional;

@Transactional
public interface TeacherRepository extends UserBaseRepository<Teacher>{

}
