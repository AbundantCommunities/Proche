package abcd

import grails.transaction.Transactional

@Transactional
class AuthenticateService {

    static private String widget = System.getenv("PROCHE_WIDGET")

    def ensurePrivileged( session ) {
        if( !session.user ) {
            throw new RuntimeException( "Privileged access!" )
        }
    }

    def check( String emailAddress, String password ) {
        // First version of authentication tied to env var
        if( emailAddress.equalsIgnoreCase("admin@communitiesunitedyeg.ca") && password.equals(widget) ) {
            log.info "${emailAddress} successfully authenticated"
            return "Administrator"
        } else {
            log.warn "${emailAddress} FAILED to authenticate"
            return null
        }
    }
}
