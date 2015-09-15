/**
 * created by 2010-6-28
 */
package nju.software.fyrs.service.sign;

/**
 * 外部接口异常
 * @author zym
 *
 */
public class ExterfaceException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -90532801862537313L;

    /**
     * 
     */
    public ExterfaceException() {
        super();
    }

    /**
     * @param message
     * @param cause
     */
    public ExterfaceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public ExterfaceException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ExterfaceException(Throwable cause) {
        super(cause);
    }

}