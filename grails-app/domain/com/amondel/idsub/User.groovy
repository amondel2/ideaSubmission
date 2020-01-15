package com.amondel.idsub

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User extends AbstractDomainObject {

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    String restToken
    String email

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static hasMany = [votes:IdeaVotes]

    static constraints = {
        id nullable: false, unique: true
        password nullable: false, blank: false, password: true, display: false
        username nullable: false, blank: false, unique: true
        restToken nullable: true, blank: true, unique: true, display: false
        email nullable: false, blank: false, email: true, unique: true, validator: {
            return (it.trim().toLowerCase().endsWith('@reedtech.com'))
        }
    }


    static mapping = {
        id generator: 'assigned'
        password column: '`password`'
    }
}
