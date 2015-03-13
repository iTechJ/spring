package com.itechart.library.webapp.i18n;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The i18n for Spring Security error messages requires to resolve locale before performing
 * Spring Security DelegatingFilterProxy
 */
public class LocaleResolverFilter extends OncePerRequestFilter {
    private static final Logger LOG = LoggerFactory.getLogger(LocaleResolverFilter.class);
    private String contextAttribute;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        resolveLocale(request);

        filterChain.doFilter(request, response);
    }

    private void resolveLocale(HttpServletRequest request) {
        try {
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext(), contextAttribute);
            LocaleResolver localeResolver = context.getBean(LocaleResolver.class);
            LocaleContextHolder.setLocale(localeResolver.resolveLocale(request));
        } catch (Exception e) {
            LOG.error("error during resolving locale", e);
        }
    }

    public String getContextAttribute() {
        return contextAttribute;
    }

    public void setContextAttribute(String contextAttribute) {
        this.contextAttribute = contextAttribute;
    }
}
