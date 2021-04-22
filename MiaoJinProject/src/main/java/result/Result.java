package result;

public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    public Result(info info) {
        if (info == null) return;
        this.code = info.getCode();
        this.msg = info.getMsg();
    }
}
