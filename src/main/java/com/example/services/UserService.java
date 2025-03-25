import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public List<User> getAllUsers() {
        return UserRepository.findAll();
    }
}