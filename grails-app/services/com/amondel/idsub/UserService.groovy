package com.amondel.idsub

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def saveResetToken(params,guid) {
        def empid = params.emp
        User emp = User.get(empid)
        emp.restToken = token
        emp.save(flush:true)
    }

    Boolean createUser(RegisterCommand registerCommand){
        User u = new User()
        u.email = registerCommand.email
        u.accountExpired = false
        u.enabled = true
        u.username = registerCommand.username
        u.password = registerCommand.password
        u.accountLocked= false
        u.passwordExpired = false
        u.validate()
        if(u.hasErrors())
            return false
        UserRole.withTransaction {
            u.save()
            UserRole ur = new UserRole()
            ur.user = u
            ur.role = Role.findByAuthority('ROLE_USER')
            ur.save()
        }
        true
    }
}
