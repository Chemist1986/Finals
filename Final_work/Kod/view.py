from animals import Animal
from animals_params import all_animals


def welcome():
    print('\n*** Добро пожаловать в Реестр домашних животных! ***')


def goodbye():
    print('\n*** Спасибо за выбор Реестра домашних животных! ***')
    print('*** Работа программы завершена ***'.center(50, ' '))


def menu_commands():
    print('\nВыберите опцию:')
    print('''
1 - Добавить в реестр несколько животных
2 - Добавить в реестр одно животное
3 - Обучить животное команде
4 - Показать всех животных
5 - Интересный факт о животном
6 - Завершить работу
\nВводите сюда --->: ''', end=''
          )


def qty_request():
    print('\nСколько животных вы желаете внести в реестр?')


def qty_check_input():
    print('Пожалуйста, введите положительное число больше нуля.')


def name_request():
    print('Введите кличку животного: ')


def did_you_know():
    print('\nЗнаете ли Вы, что...')


def animal_select():
    print('''Введите тип животного, которое вы хотите добавить:
1 - Кот
2 - Собака
3 - Хомяк
4 - Лошадь
5 - Верблюд
6 - Осел
Вводите сюда --->: ''', end=''
          )


def animal_added():
    print('Животное(ые) добавлено(ы) успешно!')


def empty_farm():
    print('\nРеестр пуст')


def menu_error():
    print('\nВведено неверное значение, пожалуйста, проверьте ввод и повторите')


def animal_for_training():
    print('\nВведите ID животного, которое вы хотите обучить новой команде: ')


def command_request():
    print('Введите название команды:')


def command_answer():
    print('Опишите совершаемое действие:')


def command_added(anim_id, key):
    print(f'{Animal.get_species(all_animals[anim_id - 1])} по кличке '
          f'{Animal.get_name(all_animals[anim_id - 1])} (ID: {anim_id}) обучен(а) новой команде: {key}')