array1 = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
array2 = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']

text = input("Please input the text that you want to be encrypted:")#Text thats gonna be encrypted
offset = input('Please input the offset:')#Offset thats gonna be used
k = int(offset)#Turning the string into interger
encrypted_message = []
decrypted_message = []


def linear_encryption(text,k):
    for x in range(len(text)):#looping over the text
        y = text[x]
        for key in y:#Looping over every leter
            i = 0
            if(key.isupper()):#If letter is capital form
                for letter in array1:
                    if key == letter:
                        new_letter = array1[i + k]
                        encrypted_message.append(new_letter)
                        break
                    i = i + 1
            else:
               for letter in array2:
                    if key == letter:
                        new_letter = array2[i + k]
                        encrypted_message.append(new_letter)
                        break
                    i = i + 1 
    return encrypted_message

def linear_decryption(encrypted_text,k):
    for x in range(len(encrypted_text)):#looping over the encrypted text
        y = encrypted_text[x]
        for key in y:#Looping over every leter
            i = 0
            if(key.isupper()):#If letter is capital form
                for letter in array1:
                    if key == letter:
                        new_letter = array1[26 + (i - k)]
                        decrypted_message.append(new_letter)
                        break
                    i = i + 1
            else:
               for letter in array2:
                    if key == letter:
                        new_letter = array2[26 + (i - k)]
                        decrypted_message.append(new_letter)
                        break
                    i = i + 1 
    return decrypted_message

if(k <=25):#if offset is less than 26

    enc2 =  linear_encryption(text,k)
    dnc2 =  linear_decryption(enc2,k)


    enc = ''.join(enc2)#turning array into string
    dnc = ''.join(dnc2)#turning array into string

    print('Encrypted message:' + enc)
    print('Decrypted message:' + dnc)#Printing the results
else:
    print('Offset too big')
            
    
