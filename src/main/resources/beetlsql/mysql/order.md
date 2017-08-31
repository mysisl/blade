sourceList
===
select * from df_orders

findOne
===
select * from df_orders where id = #{id}





===
INSERT INTO `blade_menu` (`code`, `pcode`, `alias`, `name`,
                          `icon`, `url`, `num`, `levels`,
                          `source`, `path`, `tips`, `status`, `isopen`,
                          `istemplate`, `version`)
VALUES
  ('df_orders', 'demo', '', '订单管理',
                   'fa fa-group',
                   '/order/', '1', '2', NULL, NULL, NULL, 1, 0, NULL, 0)

clearModelOperation
===
delete from blade_menu where pcode = 'df_orders'

generateOperation
===
INSERT INTO `blade_menu` (`code`, `pcode`, `alias`, `name`,
                          `icon`, `url`, `num`, `levels`,
                          `source`, `path`, `tips`, `status`, `isopen`,
                          `istemplate`, `version`)
VALUES
  ('df_orders_add', 'df_orders', 'add', '增加',
                   'btn btn-xs btn-white | fa fa-floppy-o bigger-120',
                   '/order/add', '1', '3', NULL, NULL, NULL, 1, 0, NULL, 0),
  ('df_orders_edit', 'df_orders', 'edit', '修改',
                   'btn btn-xs btn-white | fa fa-pencil  bigger-120',
                   '/order/edit', '1', '3', NULL, NULL, NULL, 1, 0, NULL, 0),
  ('df_orders_view', 'df_orders', 'add', '查看',
                   'btn btn-xs btn-white | fa fa-eye bigger-120',
                   '/order/view', '1', '3', NULL, NULL, NULL, 1, 0, NULL, 0),
  ('df_orders_del', 'df_orders', 'del', '增加',
                   'btn btn-xs btn-white | fa fa-times  bigger-120',
                   '/order/del', '1', '3', NULL, NULL, NULL, 1, 0, NULL, 0)



