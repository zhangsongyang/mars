package cn.zsy.mars.repository;

import cn.zsy.mars.entity.Employee;

import java.util.Collection;

public interface EmployeeRepository {

    void save(Employee employee);

    Collection<Employee> getAll();

    Employee get(Integer id);

    void delete(Integer id);

}
