class Animal:
    id_count = 0

    def __init__(self, name, animal_species, animal_type, animal_commands=None):
        Animal.id_count += 1
        self.id = Animal.id_count
        self.name = name
        self.animal_species = animal_species
        self.animal_type = animal_type
        self.animal_commands = animal_commands or {}

    def __str__(self):
        return f'ID: {self.id}, Кличка: {self.name}, Вид: {self.animal_species}, ' \
               f'Класс животного: {self.animal_type}, Команды животного: {self.animal_commands}'

    def set_commands(self, key, val):
        self.animal_commands[key] = val

    def get_name(self):
        return self.name

    def get_species(self):
        return self.animal_species