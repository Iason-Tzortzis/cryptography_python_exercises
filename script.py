from Crypto.Cipher import AES
import string
from Crypto import Random
import random
import io
from Crypto.Util.Padding import pad, unpad
from Crypto.Util import Counter
import json
from base64 import b64encode
from Crypto.Random import get_random_bytes


def encrypt_hash(message):
    bytes = []
    encrypted_CBC = cipherECB.encrypt(pad(message, 16))#encrypting the data with the Electronic Codebook
    random_bytes = 'WFFJLDL72OFGFKO5MJ0QO063K3J8X0FWY6RUCB6QA9LO8PTEXRWBO9R18SU1RIKHSWZ9TGMGII4Z4PWAA9CGU5B6UG7UJ02EJWV5UCQSIL7RQJ2UJUZDJGZH6WHYCQCVENZAO08ALWXUKGWK0KW6IWILS3WC1CUGALA6IBWL6I4TWP4B3QOCEOELZK0PCJYFIGINH9YJI5KNQKF2VVPNBXVNS0ARNXDBNLX8MEGLGIUCN89G5I6J87B2P7EHRHZHECC8HXHRKUM5SSQL7LGE5IWQ4ZYZ8PU9ZUMEJ7TC0GIIHNDBZ0VFRCBNVYJ1QM243TT61G1UD31U5RCO2F24V7LX6NUN4GHBUTN9M6MODJGQ47JGDOG65GLHLVH0KN5DKETM3O08QFPS1LJZAJ5QAPSIWQUKWWLO51YZRUQBAG7W1J9D58P8L98R7TIS3K8L13TOPQOEAVAKPUFUR6FW3BXD5U9XOY12RTJJV6OQK9X2B1Q9ZRV8ACK4RXV3AFVN'
    if len(encrypted_CBC) < 512:
        for i in range(0,(512-len(encrypted_CBC)),1):
            bytes.append(random_bytes[i : i + 1]) 
    bts = ''.join(bytes)
    encoded_random_bytes = str.encode(bts)
    random_bytes_cipher = cipherECB.encrypt(encoded_random_bytes)
    new_cipher = encrypted_CBC + random_bytes_cipher
    return new_cipher , len(encrypted_CBC)


key = 'U9U46RY990K0US6S'#Making the key
Encoded_key = str.encode(key)#Encoding the key
cipherECB = AES.new(Encoded_key, AES.MODE_ECB)#Creating the encryption object
decipherECB = AES.new(Encoded_key, AES.MODE_ECB)#Creating the decryption object

def main():
    
    f= open("test_file.txt" , 'r')#Opening the file which has our starting text
    if f.mode == 'r':#checking the mode to be read
        data = f.read()#reading the data from the file
    encoded_data = str.encode(data)#encoding the data
    if len(encoded_data) < 512 : 
        new_hash , y = encrypt_hash(encoded_data)

        ECBfile = open('encrypted_ECB.txt', 'w+')#Putting the encrypted text in the appropriate file
        ECBfile.write(b64encode(new_hash).decode('utf-8'))

        decrypted_message = decipherECB.decrypt(new_hash).decode('utf-8')

        first_word = []

        for i in range(0,y,1):
            first_word.append(decrypted_message[i : i + 1])
        dm = ''.join(first_word)
        print(dm)
        ECBdecryptedfile = open('decrypted_ECB.txt', 'w+')#Decrypting and putting the decrypted text in the appropriate file to check if its the same with the original
        ECBdecryptedfile.write(dm)
        print(len(new_hash))
    else:
        print('Message too big too encrypt')


main()





