package abcd

class LoginController {
    static allowedMethods = [index:'GET', authenticate:'POST']

    def authenticateService

    def index( ) {
        if( session.user ) {
            log.info( "${session.user} still logged in" )
            redirect controller: 'uberTop'
        } else {
            session.setMaxInactiveInterval( 10 * 3600 )
            log.info "Session timeout set to ${session.getMaxInactiveInterval()} seconds for unauthenticated use"
        }
    }

    def logout( ) {
        log.info "User ${session.user} logging out"
        session.user = null
        redirect action:"index"
    }

    def authenticate( ) {
        session.user = null
        log.info("Authenticate ${params.emailAddress}")

        def user = authenticateService.check( params.emailAddress, params.password )

        if( user ) {
            log.info("Saving authentication to session for ${user}")
            session.user = user
            redirect controller: 'uberTop'
        } else {
            flash.message = 'Failed to login; please try again'
            flash.nature = "WARNING"
            log.warn "FAILED to authenticate ${params.emailAddress}"
            // TODO Count login failures; lock account
            redirect action:"index"
        }
    }
}
