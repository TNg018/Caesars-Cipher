#!/usr/bin/python3
# encrypt and decrypt arbitrary string (and ints) using Ceasar shift cipher

text = input("Input word or phrase to be encrypted: ")
shift = input("Enter shift amount: ")
shift = int(shift)


def encrypt(string, s):
    encryption = ""
    #traverse each char in text
    for c in text:
        # if uppercase, use uppercase ord()
        if c.isupper():
            # ord() returns an int representing the Unicode char
            # to find the position in 0-25
            c_unicode = ord(c)
            c_index = ord(c) - ord('A')
            #shift
            new_index = (c_index + shift) % 26
            #convert to new char
            new_unicode = new_index + ord('A')
            new_char = chr(new_unicode)
            encryption += new_char

        # if lowercase, use lowercase ord()
        elif c.islower():
            c_unicode = ord(c)
            c_index = ord(c) - ord('a')
            #shift
            new_index = (c_index + shift) % 26
            #convert to new char
            new_unicode = new_index + ord('a')
            new_char = chr(new_unicode)
            encryption += new_char

        # if a number, iterate through 9 numbers
        elif c.isdigit():
            c_unicode = ord(c)
            c_index = ord(c) - ord('1')
            #shift
            new_index = (c_index + shift) % 9
            #convert to new char
            new_unicode = new_index + ord('1')
            new_char = chr(new_unicode) 
            encryption += new_char

        else:
            #if not uppercase or lowercase, leave as is
            encryption += c
            #could shift for numbers in text
    return encryption

print("\nEncryption:")
print("Plain text: ", text)
print("Shift\t  : ", str(shift))
print("Encrypted : ", encrypt(text,shift))

encrypted_text = encrypt(text,shift)

def decrypt(string):
    decryption = ""
    for c in encrypted_text:
    # if uppercase, use uppercase ord()
        if c.isupper():
            # ord() returns an int representing the Unicode char
            # to find the position in 0-25
            c_unicode = ord(c)
            c_index = ord(c) - ord('A')
            #shift
            new_index = (c_index - shift) % 26
            #convert to new char
            new_unicode = new_index + ord('A')
            new_char = chr(new_unicode)
            decryption += new_char

        # if lowercase, use lowercase ord()
        elif c.islower():
            c_unicode = ord(c)
            c_index = ord(c) - ord('a')
            #shift
            new_index = (c_index - shift) % 26
            #convert to new char
            new_unicode = new_index + ord('a')
            new_char = chr(new_unicode) 
            decryption += new_char
        # if a number, iterate through 9 numbers
        elif c.isdigit():
            c_unicode = ord(c)
            c_index = ord(c) - ord('1')
            #shift
            new_index = (c_index - shift) % 9
            #convert to new char
            new_unicode = new_index + ord('1')
            new_char = chr(new_unicode) 
            decryption += new_char
        else:
            #if not uppercase or lowercase, leave as is
            decryption += c
            #could shift for numbers in text
    return decryption

#to do: ask user if they want to decrypt
print("\nDecryption:")
print("Encrypted : ", encrypted_text)
print("Shift\t  : ", str(shift))
print("Decrypted : ", decrypt(encrypted_text))

#output every possible shift decryption
def brute_force(string):
    #letter shift index
    x = 0
    #number shift index
    lx = 0
    print("Brute force decryption: ")
    while x < 26:
        attempt = ""
        x = x+1
        lx = x+1
        for c in encrypted_text:
            if c.isupper():
                c_unicode = ord(c)
                c_index = ord(c) - ord('A')
                #shift 1
                new_index = (c_index + x) % 26
                #convert to new char
                new_unicode = new_index + ord('A')
                new_char = chr(new_unicode)
                attempt += new_char
            # if lowercase, use lowercase ord()
            elif c.islower():
                c_unicode = ord(c)
                c_index = ord(c) - ord('a')
                #shift
                new_index = (c_index + x) % 26
                #convert to new char
                new_unicode = new_index + ord('a')
                new_char = chr(new_unicode) 
                attempt += new_char
            # if a number, iterate through 9 numbers
            elif c.isdigit():
                c_unicode = ord(c)
                c_index = ord(c) - ord('1')
                #shift
                new_index = (c_index + lx) % 9
                #convert to new char
                new_unicode = new_index + ord('1')
                new_char = chr(new_unicode) 
                attempt += new_char
            else:
                attempt += c

        print(x,":\t",attempt)
    return attempt



brute_force(encrypted_text)


