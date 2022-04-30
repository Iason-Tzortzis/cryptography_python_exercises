letter_to_index = {
    'a': 0,
    'b': 1,
    'c': 2,
    'd': 3,
    'e': 4,
    'f': 5,
    'g': 6,
    'h': 7,
    'i': 8,
    'j': 9,
    'k': 10,
    'l': 11,
    'm': 12,
    'n': 13,
    'o': 14,
    'p': 15,
    'q': 16,
    'r': 17,
    's': 18,
    't': 19,
    'u': 20,
    'v': 21,
    'w': 22,
    'x': 23, 
    'y': 24,
    'z': 25,
    ' ': 26
}

index_to_letter = {
    0: 'a',
    1: 'b',
    2: 'c',
    3: 'd',
    4: 'e',
    5: 'f',
    6: 'g',
    7: 'h',
    8: 'i',
    9: 'j',
    10: 'k',
    11: 'l',
    12: 'm', 
    13: 'n',
    14: 'o',
    15: 'p',
    16: 'q',
    17: 'r',
    18: 's',
    19: 't',
    20: 'u',
    21: 'v',
    22: 'w',
    23: 'x',
    24: 'y',
    25: 'z',
    26: ' '
}

capital_letter_to_index = {
    'A': 0,
    'B': 1,
    'C': 2,
    'D': 3,
    'E': 4,
    'F': 5,
    'G': 6,
    'H': 7,
    'I': 8,
    'J': 9,
    'K': 10,
    'L': 11,
    'M': 12,
    'N': 13,
    'O': 14,
    'P': 15,
    'Q': 16,
    'R': 17,
    'S': 18,
    'T': 19,
    'U': 20,
    'V': 21,
    'W': 22,
    'X': 23, 
    'Y': 24,
    'Z': 25,
    ' ': 26
}

index_to_capital_letter = {
    0: 'A',
    1: 'B',
    2: 'C',
    3: 'D',
    4: 'E',
    5: 'F',
    6: 'G',
    7: 'H',
    8: 'I',
    9: 'J',
    10: 'K',
    11: 'L',
    12: 'M', 
    13: 'N',
    14: 'O',
    15: 'P',
    16: 'Q',
    17: 'R',
    18: 'S',
    19: 'T',
    20: 'U',
    21: 'V',
    22: 'W',
    23: 'X',
    24: 'Y',
    25: 'Z',
    26: ' '
}



message = input('Please insert the message that you want to be used for this demonstration:')#Message used
key = input('Please insert a key:')#key used for encryption


encrypted = []
decrypted = []

def vigenere_encrypt(message,key):
    
    splitting_the_message = [#splitting the message into blocks equivelant as the key
        message[i : i + len(key)] for i in range(0, len(message), len(key))
    ]
    
    for each_split in splitting_the_message:#looping over every split
        i = 0
        for letter in each_split:
            if letter.isupper():
                number = (capital_letter_to_index[letter] + capital_letter_to_index[key[i].upper()]) % 26
                encrypted.append(index_to_capital_letter[number])
                i = i + 1
            else:
                number = (letter_to_index[letter] + letter_to_index[key[i]]) % 26
                encrypted.append(index_to_letter[number])
                i = i + 1

    return encrypted

def vigenere_decrypt(cipher,key):
    
    splitting_the_encrypted_message = [
        cipher[i : i + len(key)] for i in range(0, len(cipher), len(key))
    ]

    for each_split in splitting_the_encrypted_message:#splitting the message into blocks equivelant as the key
        i = 0
        for letter in each_split:#looping over every split
            if letter.isupper():
                number = (capital_letter_to_index[letter] - capital_letter_to_index[key[i].upper()]) % 26
                decrypted.append(index_to_capital_letter[number])
                i = i + 1
            else:
                number = (letter_to_index[letter] - letter_to_index[key[i]]) % 26
                decrypted.append(index_to_letter[number])
                i = i + 1

    return decrypted


encrypted_message = vigenere_encrypt(message, key)
decrypted_message = vigenere_decrypt(encrypted_message, key)

enc = ''.join(encrypted_message)#turning array into string
dnc = ''.join(decrypted_message)#turning array into string

print("Original message: " + message)#printing the results
print("Encrypted message: " + enc)
print("Decrypted message: " + dnc)