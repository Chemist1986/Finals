import random
import view
from animals import Animal
from animals_params import *


def show_all():
    print()
    for animal in all_animals:
        print(animal)


def show_interesting_fact():
    view.did_you_know()
    print(random.choice(animal_facts))


def add_few_animal():
    view.qty_request()
    for i in range(num_input()):
        name = random.choice(animal_name)
        a_spec = random.choice(animal_species)
        a_type = animal_type[1] if a_spec in ("Лошадь", "Верблюд", "Осел") else animal_type[0]
        new_animal = Animal(name, a_spec, a_type)
        all_animals.append(new_animal)
    return all_animals


def add_new_animal():
    view.name_request()
    name = input()
    view.animal_select()
    a_spec = int(num_input())
    a_type = animal_type[1] if a_spec in (4, 5, 6) else animal_type[0]
    new_animal = Animal(name, animal_species[a_spec - 1], a_type)
    all_animals.append(new_animal)
    return new_animal


def add_command(anim_id, key, val):
    all_animals[anim_id - 1].set_commands(key, val)
    view.command_added(anim_id, key)


def num_input():
    while True:
        try:
            qty = int(input())
            if qty > 0:
                break
            else:
                view.qty_check_input()
        except ValueError:
            view.qty_check_input()
    return qty