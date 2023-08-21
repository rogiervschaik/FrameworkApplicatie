package nl.framework.applicatie.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import nl.framework.applicatie.domein.Account;
import nl.framework.applicatie.persist.AccountService;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class AuthenticationFilter implements Filter {
	
	@Autowired
	private AccountService accountService;
	
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest request = (HttpServletRequest)req;

    	String token = request.getHeader("Authorization");
    	if (StringUtils.startsWithIgnoreCase(token, "Bearer ")) {
    		token = token.substring(7);

    		Account account = this.accountService.getAccountByToken(token);
    		if (account != null) {
    			request.setAttribute("AUTH", account);
    		}
    	}

        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }

}