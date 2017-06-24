package cn.zsy.mars.repository;

import cn.zsy.mars.entity.Department;

import java.util.Collection;


public interface DepartmentRepository {

    public Collection<Department> getDepartments();

    public Department getDepartment(Integer id);

}
