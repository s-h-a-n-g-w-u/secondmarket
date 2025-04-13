package top.example.service.impl;

import top.example.dao.AdministratorUserDAO;
import top.example.dao.impl.AdministratorUserDAOImpl;
import top.example.domain.AdministratorUser;
import top.example.service.AdministratorUserService;

public class AdministratorUserServiceImpl implements AdministratorUserService {

    final private AdministratorUserDAO administratorUserDAO = new AdministratorUserDAOImpl();


    @Override
    public AdministratorUser getUserByName(String name) {
        return administratorUserDAO.getAdministratorUserByName(name);
    }

    @Override
    public AdministratorUser getUserByNameAndPassword(String name, String password) {
        return administratorUserDAO.getAdministratorUserByNameAndPassword(name, password);
    }
}
