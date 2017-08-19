class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"( controller:"uberTop" )
        "500"(view:'/error')
	}
}
