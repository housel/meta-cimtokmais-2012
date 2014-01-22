#! /usr/bin/env python

"""
usage: %prog [args]
"""

import os, sys, string
from optparse import OptionParser
import subprocess

def main(argv, stdout, environ):

  parser = OptionParser(__doc__.strip())
  (options, args) = parser.parse_args()

  if (len(args) < 3):
    print >> sys.stderr, 'Need to pass rpath token to replace'
    sys.exit(1)

  for root, dirs, files in os.walk(args[0]):
    for f in files:
      r = subprocess.Popen(['chrpath', os.path.join(root,f)], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
      (o,e) = r.communicate()

      if (r.returncode == 0):
        i = o.find('RPATH=')
        if i > -1:
          old_rpath = o[i + 6:].strip().split(':')
          new_rpath = []
          for d in old_rpath:
            for j in xrange(1, len(args), 2):
              if d.startswith(args[j]):
                d = args[j + 1] + d[len(args[j]):]
                break
            new_rpath.append(d)

        if new_rpath != old_rpath:
          newrp = ':'.join(new_rpath)
          subprocess.check_call(['chrpath', os.path.join(root,f), '-r', newrp])

if __name__ == "__main__":
  main(sys.argv, sys.stdout, os.environ)
