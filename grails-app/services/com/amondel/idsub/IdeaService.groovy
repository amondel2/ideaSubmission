package com.amondel.idsub

import grails.gorm.services.Service

@Service(Idea)
interface IdeaService {

    Idea get(Serializable id)

    List<Idea> list(Map args)

    Long count()

    void delete(Serializable id)

    Idea save(Idea idea)

}