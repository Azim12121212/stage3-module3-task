package com.mjc.school.service.errorsexceptions;

public enum Errors {
    ERROR_NEWS_ID_FORMAT("0001", "News Id should be number"),
    ERROR_NEWS_ID_VALUE("0002", "News id can not be null or less than 1. News id is: "),
    ERROR_NEWS_ID_NOT_EXIST("0003", "News with id {id} does not exist."),
    ERROR_NEWS_TITLE_LENGTH("0011", "News title can not be less than 5 and more than 30 symbols. News title is: "),
    ERROR_NEWS_CONTENT_LENGTH("0012", "News content can not be less than 5 and more than 255 symbols. News content is: "),
    ERROR_NEWS_AUTHOR_ID_FORMAT("0021", "Author Id should be number"),
    ERROR_NEWS_AUTHOR_ID_VALUE("0022", "Author id can not be null or less than 1. Author id is: "),
    ERROR_NEWS_AUTHOR_ID_NOT_EXIST("0023", "Author Id does not exist. Author Id is: "),
    ERROR_COMMAND_NOT_FOUND("0031", "Command not found."),
    ERROR_AUTHOR_ID_FORMAT("0041", "Author Id should be number"),
    ERROR_AUTHOR_ID_VALUE("0042", "Author id can not be null or less than 1. News id is: "),
    ERROR_AUTHOR_ID_NOT_EXIST("0043", "Author with id {id} does not exist."),
    ERROR_AUTHOR_NAME_LENGTH("0051", "Author name can not be less than 3 and more than 15 symbols. Author name is: "),
    ERROR_AUTHOR_NAME_NOT_EXIST("0052", "News with author name {id} do not exist."),
    ERROR_TAG_ID_FORMAT("0061", "Tag Id should be number"),
    ERROR_TAG_ID_VALUE("0062", "Tag id can not be null or less than 1. Tag id is: "),
    ERROR_TAG_ID_NOT_EXIST("0063", "Tag with id {id} does not exist."),
    ERROR_TAG_NAME_LENGTH("0071", "Tag name can not be less than 3 and more than 15 symbols. Tag name is: "),
    ERROR_TAG_NAME_NOT_EXIST("0072", "News with tag name {id} do not exist.");

    private String errorCode;
    private String errorMessage;

    private Errors() {
    }

    private Errors(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorData(String insert, boolean replace) {
        String result = "ERROR_CODE: " + getErrorCode() + " ERROR_MESSAGE: ";
        if (replace) {
            result += getErrorMessage().replace("{id}", insert);
        } else {
            result += getErrorMessage() + insert;
        }
        return result;
    }
}