import view
from user_commands import show_all, add_few_animal, add_command, all_animals, add_new_animal, num_input, show_interesting_fact

menu = {
    '1': add_few_animal,
    '2': add_new_animal,
    '3': add_command,
    '4': show_all,
    '5': show_interesting_fact,
    '6': exit
}


def start_registry():
    view.welcome()
    while True:
        view.menu_commands()
        program = input()
        try:
            program = menu[program]
            if program == exit:
                view.goodbye()
                exit(0)
            elif program == add_few_animal:
                add_few_animal()
                view.animal_added()
            elif program == add_new_animal:
                add_new_animal()
                view.animal_added()
            elif program == show_all:
                if len(all_animals) > 0:
                    show_all()
                else:
                    view.empty_farm()
            elif program == add_command:
                if len(all_animals) == 0:
                    view.empty_farm()
                else:
                    show_all()
                    view.animal_for_training()
                    id_param = int(num_input())
                    view.command_request()
                    key_type = input()
                    view.command_answer()
                    val_type = input()
                    add_command(id_param, key_type, val_type)
            elif program == show_interesting_fact:
                show_interesting_fact()
        except KeyError:
            view.menu_error()