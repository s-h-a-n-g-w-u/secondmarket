package top.example.service;

import top.example.domain.AdministratorUser;

/**
 * @Description: TODO
 * @Author: system
 * @Date: 2024-12-05
 */
public interface AdministratorUserService {
    AdministratorUser getUserByName(String name);

    AdministratorUser getUserByNameAndPassword(String name, String password);
}
