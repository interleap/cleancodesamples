package co.interleap.samples.systems;

@Controller
@RequestMapping("/account")
public class AccountController {

  AccountService accountService;

  public AccountController() {
    accountService = new AccountServiceImpl();
  }
}