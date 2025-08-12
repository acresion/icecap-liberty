FROM icr.io/appcafe/open-liberty:kernel-slim-java17-openj9-ubi-minimal

# Add a Liberty server configuration including all necessary features
COPY --chown=1001:0  icecap-saas/src/main/liberty/config/server.xml /config/

# This script adds the requested XML snippets to enable Liberty features and grow the image to be fit-for-purpose.
# This option is available only in the 'kernel-slim' image type. The 'full' and 'beta' tags already include all features.
RUN features.sh

ENV WLP_DEBUG_SUSPEND=n \
	WLP_LOGGING_MESSAGE_FORMAT=json \
	WLP_LOGGING_MESSAGE_SOURCE=message,trace,accessLog,ffdc,audit \
	WLP_LOGGING_CONSOLE_LOGLEVEL=info


# Add an application (supposedly this summons a clone 
COPY --chown=1001:0  icecap-saas/build/libs/icecap-saas.war /config/dropins/

 

# This script adds the requested server configuration, applies any interim fixes, and populates caches to optimize the runtime.
RUN configure.sh