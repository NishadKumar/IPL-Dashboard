import { React, useEffect, useState } from 'react';
import { MatchDetailsCard } from '../components/MatchDetailsCard';
import { MatchSmallCard } from '../components/MatchSmallCard';

export const TeamPage = () => {

    const [team, setTeam] = useState({latestMatches:[]});

    useEffect(() => {
        const fetchMatches = async () => {
            const response = await fetch('http://localhost:8080/team/Rajasthan%20Royals');
            const data = await response.json();
            console.log(data);
            setTeam(data);
        };
        fetchMatches();
    }, []
    );

    return (
        <div className="TeamPage">
            <h1>{team.teamName}</h1>
            <MatchDetailsCard match={team.latestMatches[0]}/>
            {team.latestMatches.slice(1).map(latestMatch => <MatchSmallCard match={latestMatch}/> )}

        </div>
    );
}
