package com.amondel.idsub

class Status implements Serializable {

    def utilService = Utils.getInstance()
    private static final serialVersionUID = 1L

    static constraints = {
    }

    static mapping = {
        id generator: 'assigned'
        version false
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

    @Override
    public String toString(){
        return this.name
    }

    static hasMany = [ideas:Idea]
    String id
    String name
}
