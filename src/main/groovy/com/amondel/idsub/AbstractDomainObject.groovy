package com.amondel.idsub

class AbstractDomainObject implements Serializable {

    String id

    def utilService = Utils.getInstance()
    private static final serialVersionUID = 1L

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


}
