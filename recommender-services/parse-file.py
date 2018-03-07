import sys  
import os
import re

def main():  
   filepath = r'/home/hadoop/recommender/recommendation.txt'
   content = ''
   if not os.path.isfile(filepath):
       print("File path {} does not exist. Exiting...".format(filepath))
       sys.exit()
   content = content +"user,movie\n"
   with open(filepath) as fp:
       for line in fp:
           user_s = re.search(r'(.*?)\[',line, re.IGNORECASE)
           movies_s = re.search(r'\[(.*?)\]',line, re.IGNORECASE)
           if user_s and movies_s:
               user = user_s.group(1).strip()
               movies = movies_s.group(1)
               for movie in movies.split(','):
                  content = content + "%s,%s\n" % (user,movie[:movie.index(":")]) 
   generate_csv(content)


def generate_csv(content):
   f = open('/home/hadoop/recommender/output.csv','w') 
   f.write(content)
   f.close()

if __name__ == '__main__':  
   main()