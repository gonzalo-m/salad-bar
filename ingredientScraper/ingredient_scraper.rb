#!/usr/bin/env ruby

url = 'http://sweetgreen.com/menu/'
regexp = 's/.*"title" >\(.*\)&nbsp;&nbsp;/\1/p'

curl_command = 'curl "'  << url << '" > ' << 'temp'
scrape_command = 'cat temp | sed -n \'' << regexp << '\'' << ' | sort > ingredients.txt'
rm_command = 'rm temp'

system(curl_command)
system(scrape_command)
system(rm_command)