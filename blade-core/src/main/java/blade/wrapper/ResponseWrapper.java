/**
 * Copyright (c) 2015, biezhi 王爵 (biezhi.me@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package blade.wrapper;

import javax.servlet.http.HttpServletResponse;

import blade.render.ModelAndView;
import blade.servlet.Response;

/**
 * Response增强
 *
 * @author	<a href="mailto:biezhi.me@gmail.com" target="_blank">biezhi</a>
 * @since	1.0
 */
public class ResponseWrapper extends Response {

    private Response delegate;

    private boolean redirected = false;
    
    public ResponseWrapper() {
		// TODO Auto-generated constructor stub
	}
    
    public ResponseWrapper(Response delegate) {
		this.delegate = delegate;
	}
    
    public void setDelegate(Response delegate) {
        this.delegate = delegate;
    }

    public Response getDelegate() {
        return delegate;
    }

    @Override
    public void status(int statusCode) {
        delegate.status(statusCode);
    }

    @Override
    public void body(String body) {
        delegate.body(body);
    }

    @Override
    public String body() {
        return delegate.body();
    }

    @Override
    public boolean equals(Object obj) {
        return delegate.equals(obj);
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public HttpServletResponse servletResponse() {
        return delegate.servletResponse();
    }

    public void go(String path) {
    	delegate.go(path);
    }
    
    @Override
    public void redirect(String location) {
        redirected = true;
        delegate.redirect(location);
    }

    @Override
    public void redirect(String location, int httpStatusCode) {
        redirected = true;
        delegate.redirect(location, httpStatusCode);
    }

    /**
     * @return true if redirected has been done
     */
    boolean isRedirected() {
        return redirected;
    }

    @Override
    public void header(String header, String value) {
        delegate.header(header, value);
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    @Override
    public void contentType(String contentType) {
        delegate.contentType(contentType);
    }

    @Override
    public void cookie(String name, String value) {
        delegate.cookie(name, value);
    }

    @Override
    public void cookie(String name, String value, int maxAge) {
        delegate.cookie(name, value, maxAge);
    }

    @Override
    public void cookie(String name, String value, int maxAge, boolean secured) {
        delegate.cookie(name, value, maxAge, secured);
    }

    @Override
    public void cookie(String path, String name, String value, int maxAge, boolean secured) {
        delegate.cookie(path, name, value, maxAge, secured);
    }

    @Override
    public void removeCookie(String name) {
        delegate.removeCookie(name);
    }
    
    /**
	 * 渲染一个视图
	 * @param		view
	 */
	public void render(String view){
		delegate.render(view);
	}
	
	/**
	 * 根据ModelAndView进行渲染
	 * @param		modelAndView
	 */
	public void render(ModelAndView modelAndView){
		delegate.render(modelAndView);
	}
	
	/**
	 * 返回文字格式
	 * @param text
	 */
	public void text(String text){
		delegate.text(text);
	}
	
	/**
	 * 返回json格式
	 * @param json
	 */
	public void json(String json){
		delegate.json(json);
	}
	
	/**
	 * 返回xml格式
	 * @param xml
	 */
	public void xml(String xml){
		delegate.xml(xml);
	}
	
	/**
	 * 返回js格式
	 * @param javascript
	 */
	public void javascript(String javascript){
		delegate.javascript(javascript);
	}
	
	/**
	 * 返回html格式
	 * @param html
	 */
	public void html(String html){
		delegate.html(html);
	}
	
	/**
	 * 404默认视图
	 * 
	 * @param viewName
	 */
	public void render404(String viewName){
		delegate.render404(viewName);
	}
	
	/**
	 * 500默认视图
	 * 
	 * @param bodyContent
	 */
	public void render500(String bodyContent){
		delegate.render500(bodyContent);
	}
}
