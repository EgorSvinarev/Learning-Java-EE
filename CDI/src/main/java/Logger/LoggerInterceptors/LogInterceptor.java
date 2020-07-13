package Logger.LoggerInterceptors;

import javax.inject.Inject;
import javax.interceptor.*;
import Logger.Logger;

public class LogInterceptor {

	@Inject
	private Logger logger;	
	
	@AroundConstruct
	private void init(InvocationContext ic) throws Exception {
		logger.log("Logging system starts.");
		try {
			ic.proceed();
		}
		finally { }
	}

	@AroundInvoke
	private Object logging(InvocationContext ic) throws Exception {
		logger.log(ic.getTarget().toString() + " - " + ic.getMethod().getName());
		try {
			return ic.proceed();
		}
		finally { }
	}
	
}
