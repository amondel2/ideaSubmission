package com.amondel.idsub

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'authority')
@ToString(includes = 'authority', includeNames = true, includePackage = false)
class Role extends AbstractDomainObject {


    String authority

    static constraints = {
        authority nullable: false, blank: false, unique: true
    }

    static mapping = {
        id generator: 'assigned'
        cache true
    }
}
