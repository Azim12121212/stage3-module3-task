package com.mjc.school.controller.menu.authorcommands;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.menu.MenuOptions;
import com.mjc.school.controller.menuinterface.MenuCommands;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.errorsexceptions.Errors;
import com.mjc.school.service.errorsexceptions.NotFoundException;
import com.mjc.school.service.errorsexceptions.ValidatorException;
import com.mjc.school.service.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.mjc.school.controller.menu.MenuInputTexts.*;

@Component
public class GetAuthorByIdCommand implements MenuCommands {
    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController;
    private final Scanner scanner;

    public GetAuthorByIdCommand(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController) {
        this.authorController = authorController;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.println(OPERATION.getText() + MenuOptions.GET_AUTHOR_BY_ID.getOptionName());
        Validator validator = new Validator();
        try {
            System.out.println(ENTER_AUTHOR_ID);
            String id = scanner.nextLine();
            if (!validator.validateId(id)) {
                throw new ValidatorException(Errors.ERROR_AUTHOR_ID_FORMAT.getErrorData("", false));
            }

            System.out.println(authorController.readById(Long.parseLong(id)));
        } catch (ValidatorException | NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}