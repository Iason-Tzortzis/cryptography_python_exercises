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

key = ''.join(random.SystemRandom().choice(string.ascii_uppercase + string.digits) for _ in range(16))#Generating the random key
print('The generated key is: ' + key)
iv = Random.new().read(AES.block_size)#Generating the Initialization vector
print('The Initialization vector is : ' + str(iv))
Encoded_key = str.encode(key)#Encoding the key
print('The encoded key is: ' + key)
cipherECB = AES.new(Encoded_key, AES.MODE_ECB)#Creating the encryption object
decipherECB = AES.new(Encoded_key, AES.MODE_ECB)#Creating the decryption object

cipherCBC = AES.new(Encoded_key, AES.MODE_CBC,iv)#Creating the encryption object
decipherCBC = AES.new(Encoded_key, AES.MODE_CBC,iv)#Creating the decryption object

cipherCTR = AES.new(Encoded_key, AES.MODE_CTR)#Creating the encryption object
nonce = cipherCTR.nonce#Creating the Initialization vector
print('The Initialization vector for CTR method is: ' + key)


f= open("test_file.txt" , 'r')#Opening the file which has our starting text
if f.mode == 'r':#checking the mode to be read
    data = f.read()#reading the data from the file
print('The raw data are: ' + data)
encoded_data = str.encode(data)#encoding the data
print('The encoded data are: ' + data)
encrypted_ECB = cipherECB.encrypt(pad(encoded_data, 16))#encrypting the data with the Electronic Codebook method
print('Encrypted data with ECB method: ' + str(encrypted_ECB))
encrypted_CBC = cipherCBC.encrypt(pad(encoded_data, 16))#encrypting the data with the Cipher Block Chaining method
print('Encrypted data with CBC method: ' + str(encrypted_CBC))
ECBfile = open('encrypted_ECB.txt', 'w+')#Putting the encrypted text in the appropriate file
ECBfile.write(b64encode(encrypted_ECB).decode('utf-8'))

ECBdecryptedfile = open('decrypted_ECB.txt', 'w+')#Decrypting and putting the decrypted text in the appropriate file to check if its the same with the original
ECBdecryptedfile.write((decipherECB.decrypt(encrypted_ECB)).decode('utf-8'))

CBCfile = open('encrypted_CBC.txt', 'w+')#Putting the encrypted text in the appropriate file
CBCfile.write(b64encode(encrypted_CBC).decode('utf-8'))

CBCdecryptedfile = open('decrypted_CBC.txt', 'w+')#Decrypting and putting the decrypted text in the appropriate file to check if its the same with the original
CBCdecryptedfile.write((decipherCBC.decrypt(encrypted_CBC)).decode('utf-8'))


decipher_CTR = AES.new(Encoded_key, AES.MODE_CTR, nonce=nonce)#Creating the encryption object
encrypted_CTR = cipherCTR.encrypt(encoded_data)#encrypting the data with the Counter Mode method
print('Encrypted data with CTR method: ' + str(encrypted_CTR))
CTRfile = open('encrypted_CTR.txt', 'w+')#Putting the encrypted text in the appropriate file
CTRfile.write(b64encode(encrypted_CTR).decode('utf-8'))


decrypted_CTR = decipher_CTR.decrypt(encrypted_CTR)#Decrypting the encrypted text
CBCdecryptedfile = open('decrypted_CTR.txt', 'w+')#Putting the decrypted text in the appropriate file to check if its the same with the original
CBCdecryptedfile.write(decrypted_CTR.decode('utf-8'))




