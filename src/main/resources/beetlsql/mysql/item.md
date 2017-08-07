sourceList
===
select * from rec_item

findOne
===
select * from rec_item where id = #{id}

list
===
select a.*,c.name creater,u.name updater,d.fullname sysdept,r.name sysrole from rec_item a LEFT JOIN blade_user c on c.id = a.created_by
  LEFT JOIN blade_user u on u.id = a.updated_by
  LEFT JOIN blade_dept d on d.id = a.s_dept_id
  LEFT JOIN blade_role r on r.id = a.s_role_id

