package com.amondel.idsub

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic


@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

	def utilService = Utils.getInstance()
	private static final long serialVersionUID = 1

	String id
	String authority

	static constraints = {
		authority nullable: false, blank: false, unique: true
	}

	def beforeValidate() {
		if(!id || id.equals(null)) {
			id  = utilService.idGenerator()
		}
	}

	def beforeInsert() {
		if(!id || id.equals(null)) {
			id  = utilService.idGenerator()
		}
	}


	static mapping = {
		id generator: 'assigned'
		cache true
	}
}
