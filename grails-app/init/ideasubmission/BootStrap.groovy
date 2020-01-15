package ideasubmission

import com.amondel.idsub.*

class BootStrap {

    def init = { servletContext ->
        String pass = System.getProperty("DB_PASSWORD")?.toString() ?: System.getenv("DB_PASSWORD")?.toString()
        Status.withTransaction {
            Status s = Status.findOrCreateByName("Approved")
            s.save(failOnError: true)
            Status s1 = Status.findOrCreateByName("Rejected")
            s1.save(failOnError: true)
            Status s2 = Status.findOrCreateByName("New")
            s2.save(failOnError: true)
        }
        Role r
        Role r1
        Role.withTransaction {
            r = Role.findOrCreateByAuthority("ROLE_ADMIN")
            r.save(failOnError: true)
            r1 = Role.findOrCreateByAuthority("ROLE_USER")
            r1.save(failOnError: true)
        }

        User ua
        User uu
        User.withTransaction {
            ua = User.findByUsername("admin")
            if (!ua) {
                ua = new User()
                ua.username = "admin"
                ua.password = pass
                ua.enabled = true
                ua.accountExpired = false
                ua.accountExpired = false
                ua.email = "ideaadmin@reedtech.com"
                ua.save()
            }
        }
        User.withTransaction {
            uu = User.findByUsername("aaron")
            if (!uu) {
                uu = new User()
                uu.username = "aaron"
                uu.password = pass
                uu.enabled = true
                uu.accountExpired = false
                uu.accountExpired = false
                uu.email = "amondelblatt@reedtech.com"
                uu.save()
            }
        }

        UserRole.withTransaction {
            UserRole ur = UserRole.findOrCreateByUserAndRole(uu,r1)
            ur.save()
            UserRole ur1 = UserRole.findOrCreateByUserAndRole(ua,r)
            ur1.save()
            UserRole ur2 = UserRole.findOrCreateByUserAndRole(ua,r1)
            ur2.save()
        }

        Tag.withTransaction {
            ['eWord','eTable','eHeader','eEdit','ImagePrep'].each { String t ->
                Tag t1 = Tag.findOrCreateByName(t)
                t1.save()
            }
        }




    }
    def destroy = {
    }
}
